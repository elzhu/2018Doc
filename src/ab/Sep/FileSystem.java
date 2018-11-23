package ab.Sep;

import java.util.Map;

public class FileSystem {
    Map<String, Integer> pathMap;
    Map<String, Runnable> callBackMap;

    public FileSystem(){
        this.pathMap = pathMap;
        this.callBackMap = callBackMap;
        this.pathMap.put("", 0);
    }
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

    public boolean setValue(String path, int value) {
        if (!pathMap.containsKey(path)) {
            return false;
        }
        pathMap.put(path, value);
        // Traggie callback
        String currentPath = path;
        while (currentPath.length() > 0) {
            if (callBackMap.containsKey(currentPath)) {
                callBackMap.get(currentPath).run();
            }
           int lastSlashIndex = path.lastIndexOf("/");
            currentPath = currentPath.substring(0, lastSlashIndex);
        }
        return true;
    }
    public Integer get(String path) {
      return pathMap.get(path);
    }

    public boolean watch(String path, Runnable callback) {
        if (!pathMap.containsKey(path)) {
            return false;
        }
        callBackMap.put(path, callback);
        return true;
    }

}
