package com.lalit.sapient.coding.problem.fileUtils;

import com.lalit.sapient.coding.problem.model.InputFields;
import com.lalit.sapient.coding.problem.utils.CurrencyConverter;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerCapitaCSVFileService implements FileService {

    @Override
    public List<InputFields> readFromFile(String filePath) {
        List<InputFields> listOfInputData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int rowCount = 0;
            while (line != null) {
                if (rowCount > 0) {
                    String[] splitCSV = line.split(",");
                    InputFields inputFields = new InputFields(splitCSV[0], splitCSV[1], splitCSV[2], new BigDecimal(splitCSV[3]), splitCSV[4]);
                    listOfInputData.add(inputFields);
                }
                ++rowCount;
                line = br.readLine();
            }
            return listOfInputData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Map<String, BigDecimal>> buildOutputData(Object list) {
        Map<String, Map<String, BigDecimal>> map = new HashMap<>();
        for (InputFields inputFields : (List<InputFields>) list) {
            if (!("".equalsIgnoreCase(inputFields.getCountry()))) {
                if (map.containsKey(inputFields.getCountry())) {
                    map.put(inputFields.getCountry(), putAmountByGender(inputFields, map.get(inputFields.getCountry())));
                } else {
                    map.put(inputFields.getCountry(), putAmountByGender(inputFields, new HashMap<>()));
                }
            } else {
                if (map.containsKey(inputFields.getCity())) {
                    map.put(inputFields.getCity(), putAmountByGender(inputFields, map.get(inputFields.getCity())));
                } else {
                    map.put(inputFields.getCity(), putAmountByGender(inputFields, new HashMap<>()));
                }
            }
        }
        return map;
    }

    private Map<String, BigDecimal> putAmountByGender(InputFields inputFields, Map<String, BigDecimal> genderToAmount) {
        if (genderToAmount.containsKey(inputFields.getGender())) {
            genderToAmount.put(inputFields.getGender(), genderToAmount.get(inputFields.getGender()).add(CurrencyConverter.toUSD(inputFields.getCurrency(), inputFields.getAmount())));
        } else {
            genderToAmount.put(inputFields.getGender(), CurrencyConverter.toUSD(inputFields.getCurrency(), inputFields.getAmount()));
        }
        return genderToAmount;
    }

    @Override
    public String getReportName() {
        return "PerCapita";
    }

    @Override
    public String getFileFormat() {
        return "CSV";
    }

    @Override
    public void writeToFile(String filePath, Object output) {
        try (FileWriter br = (new FileWriter(filePath))) {
            br.append("Country/City");
            br.append(",");
            br.append("Gender");
            br.append(",");
            br.append("AverageAmount");
            br.append("\n");
            for (Map.Entry<String, Map<String, BigDecimal>> entrySet : ((Map<String, Map<String, BigDecimal>>) output).entrySet()) {
                String countryCityName = entrySet.getKey();
                for (Map.Entry<String, BigDecimal> entry : entrySet.getValue().entrySet()) {
                    br.append(countryCityName);
                    br.append(",");
                    br.append(entry.getKey());
                    br.append(",");
                    br.append(entry.getValue().toString());
                    br.append("\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
