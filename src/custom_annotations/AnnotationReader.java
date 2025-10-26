package custom_annotations;

public class AnnotationReader {
    public static void main(String[] args) {
        Task task = new Task();

        // We are using reflection to read annotations
        try {
            // getDeclaredMethods() returns all the methods of the class
            for (var method : task.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Important.class)) {
                    Important important = method.getAnnotation(Important.class);
                    System.out.println("Important Method: " + method.getName());
                    System.out.println("Description: " + important.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
