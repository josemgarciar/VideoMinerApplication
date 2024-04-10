package VimeoMiner.etl;

public class ParseId {

    public static String getIdFromUri(String uri){
        String[] splits = uri.split("/");
        //    /users/adultswim";
        return splits[2].trim();
    }

    public static String getIdFromComments(String uri) {
        String[] splits = uri.split("/");
        return splits[4].trim();
    }
}
