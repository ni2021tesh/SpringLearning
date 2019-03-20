package spring_scope;

public class SingletonBean {

    private String name;
    private String message;
    private String createdBy;

    static int count = 0;

    static {
        count++;
    }

    public SingletonBean() {
        System.out.println("Default Constructor executed...");
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "SingletonBean{" + "name='" + name + '\'' + ", message='" + message + '\'' + ", createdBy='" + createdBy + '\'' + '}';
    }
}
