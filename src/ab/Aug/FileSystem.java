package ab.Aug;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    Map<String, Integer> pathMap;
    Map<String, Runnable> callBackMap;

    public FileSystem() {
        this.pathMap = new HashMap<>();
        this.callBackMap = new HashMap<>();
        this.pathMap.put("", 0);
    }
/*
  create("/a", 1)
  get("/a") = 1
  create("/a/b", 2)
  get("/a/b") = 2
  create("/c/d",1) - error
  get("/c") - error

 */
    public boolean create(String path, int value) {
        if (pathMap.containsKey(path)) {
            return false;
        }
        int lastSlashIndex = path.lastIndexOf("/");
        if (!pathMap.containsKey(path.substring(0, lastSlashIndex))) {
            return false;
        }
        pathMap.put(path, value);
        return true;
    }

    public Integer get(String path) {
        return pathMap.get(path);
    }

    public boolean set(String path, int value) {
        if (!pathMap.containsKey(path)) {
            return false;
        }
        pathMap.put(path, value);
        String curPath = path;
        while (curPath.length() > 0) {
            if (callBackMap.containsKey(curPath)) {
                callBackMap.get(curPath).run();
            }
            int lastSlashIndex = path.lastIndexOf("/");
            curPath = curPath.substring(0, lastSlashIndex);
        }
        return true;
    }
    public boolean watch(String path, Runnable callBack) {
        if (!pathMap.containsKey(path)) {
            return false;
        }
        callBackMap.put(path, callBack);
        return true;
    }
}
