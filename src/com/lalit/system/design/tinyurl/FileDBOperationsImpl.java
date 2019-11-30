package com.lalit.system.design.tinyurl;

import java.io.*;

public class FileDBOperationsImpl implements DBOperations {

    @Override
    public String save(String completeUrl) throws IOException {
        File fileDB = new File("/Users/lalitgoyal/IdeaProjects/ReviseProgramming/src/com/lalit/system/design/tinyurl/InFileDB.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            String shortUrl = fetchShortUrl(completeUrl);
            if (shortUrl == null) {
                fw = new FileWriter(fileDB, true);
                bw = new BufferedWriter(fw);
                int randomNum = (int) (100000000 * Math.random());
                shortUrl = BaseConverter.fromBase10to64(randomNum);
                String insertRecord = randomNum + "|" + completeUrl + "|" + shortUrl;
                bw.newLine();
                bw.write(insertRecord);
            }
            return shortUrl;
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (bw != null || fw != null) {
                bw.close();
                fw.close();
            }
        }
    }

    public String fetchOriginalUrl(String shortUrl) throws IOException {
        int id = BaseConverter.fromBase64to10(shortUrl);
        File fileDB = new File("/Users/lalitgoyal/IdeaProjects/ReviseProgramming/src/com/lalit/system/design/tinyurl/InFileDB.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileDB);
            br = new BufferedReader(fr);
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String column[] = line.split("\\|");
                if (id == Integer.valueOf(column[0])) {
                    return column[1];
                }
                line = br.readLine();
            }
            return null;
        } catch (FileNotFoundException e) {
            throw new IOException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            br.close();
            fr.close();
        }
    }

    private String fetchShortUrl(String url) throws IOException {
        File fileDB = new File("/Users/lalitgoyal/IdeaProjects/ReviseProgramming/src/com/lalit/system/design/tinyurl/InFileDB.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileDB);
            br = new BufferedReader(fr);
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String column[] = line.split("\\|");
                if (url.equals(column[1])) {
                    return column[2];
                }
                line = br.readLine();
            }
            return null;
        } catch (FileNotFoundException e) {
            throw new IOException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            br.close();
            fr.close();
        }
    }

}
