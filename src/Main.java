public class Main {
    public static void main(String[] args) {
        HttpDirector director = new HttpDirector();

        //1 Сборка объекта Java
        HttpObjectBuilder objectBuilder = new HttpObjectBuilder();
        director.makeAuthPostRequest(objectBuilder);
        HttpRequest requestObject = objectBuilder.getResult();

        System.out.println("=== 1. JAVA OBJECT REPRESENTATION ===");
        System.out.println(requestObject);

        System.out.println();

        //Сборка текстовой команды cURL
        CurlCommandBuilder curlBuilder = new CurlCommandBuilder();
        director.makeAuthPostRequest(curlBuilder);
        String curlCommand = curlBuilder.getResult();

        System.out.println("=== 2. TEXT (cURL) REPRESENTATION ===");
        System.out.println(curlCommand);

        System.out.println();

        //Тест конфигурации GET-запроса
        CurlCommandBuilder getCurlBuilder = new CurlCommandBuilder();
        director.makeGetUserRequest(getCurlBuilder);
        System.out.println("=== 3. GET REQUEST (cURL) ===");
        System.out.println(getCurlBuilder.getResult());
    }
}