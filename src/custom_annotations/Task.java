package custom_annotations;

public class Task {

    @Important("Analyze the requirements thoroughly")
    public void analyzeRequirements() {
        System.out.println("Analyzing requirements...");
    }

    public void designSystem() {
        System.out.println("Designing system...");
    }

    @Important("Implement the core functionality")
    public void implementCode() {
        System.out.println("Implementing code...");
    }

    @Important("Test the system extensively")
    public void testSystem() {
        System.out.println("Testing system...");
    }

    public void deploySystem() {
        System.out.println("Deploying system...");
    }

    public void maintainSystem() {
        System.out.println("Maintaining system...");
    }

}
