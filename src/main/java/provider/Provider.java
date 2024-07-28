package provider;

import java.net.URL;

public class Provider {
    public static URL getResource(Resource resource) {
        return switch (resource) {
            case ANCHOR -> provider("/html/anchor.html");
            case CHECKBOX -> provider("/html/checkbox.html");
            case LISTBOX -> provider("/html/listbox.html");
        };
    }

    private static URL provider(String sourceLocation) {
        URL resource = Provider.class.getResource(sourceLocation);
        if (null == resource) {
            throw new IllegalArgumentException("Cannot find the resource.");
        }

        return resource;
    }
}
