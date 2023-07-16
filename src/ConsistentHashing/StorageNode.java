package ConsistentHashing;

public  class StorageNode {
    private String name;
    private String hostName;
    StorageNode(String name , String hostName){
        this.name = name ;
        this.hostName = hostName;
    }

    public String get_file(String path ){
        return "";
    }
    public void put_file(String path ){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
