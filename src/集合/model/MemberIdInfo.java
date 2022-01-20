package 集合.model;

public class MemberIdInfo {

    private String idType;

    private String id;

    public MemberIdInfo(String idType, String id) {
        this.idType = idType;
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
