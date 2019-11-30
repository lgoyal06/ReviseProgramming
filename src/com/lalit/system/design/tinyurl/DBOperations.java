package com.lalit.system.design.tinyurl;

import java.io.IOException;

public interface DBOperations {

    String save(String completeUrl) throws IOException;

    String fetchOriginalUrl(String shortUrl) throws IOException;


}
