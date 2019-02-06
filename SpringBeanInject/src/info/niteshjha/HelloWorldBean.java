package info.niteshjha;

public class HelloWorldBean {
    private String message;

    /**
     * @apiNote Spring uses this default constructor for creating the object.
     */
    private HelloWorldBean() {
        System.out.println("Inside Default constructor of HelloWorldBean");
    }

    /**
     * @param message the message property
     * @apiNote Spring uses this setter to populate the data
     */
    public void setMessage(String message) {
        this.message = message;
        System.out.println("Inside SetMessage method.");
    }

    /**
     * @return message
     * @apiNote get the data from {@link HelloWorldBean}
     */
    public String getMessage() {
        return message;
    }

}
