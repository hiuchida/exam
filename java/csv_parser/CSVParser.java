package csv_parser;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    private ArrayList<String> list;
    private int status;
    private StringBuffer sb;
    
    public CSVParser() {
        list = new ArrayList<String>();
        status = 0;
        sb = new StringBuffer();
    }
    
    public List<String> getFields() {
        return list;
    }
    
    public boolean splitCsv(String str, int lineNo) {
        boolean bContinue = false;
        for (int i=0; i<str.length(); i++) {
            char ch1 = str.charAt(i);
            /*
            if (ch1 < ' ') {
            	System.err.println(lineNo + ": " + ch1);
            }
            */
            char ch2 = (i+1 < str.length()) ? str.charAt(i+1) : 0;
            switch (status) {
            case 0: //フィールドの先頭
                if ('\"' == ch1) {
                    sb = new StringBuffer();
                    sb.append(ch1);
                    status = 2;
                } else if (',' == ch1) {
                    list.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb = new StringBuffer();
                    sb.append(ch1);
                    status = 1;
                }
                break;
            case 1: //フィールドの途中
                if (',' == ch1) {
                    list.add(sb.toString());
                    sb = new StringBuffer();
                    status = 0;
                } else {
                    sb.append(ch1);
                }
                break;
            case 2: //ダブルクォートの途中
                if ('\"' == ch1) {
                    if ('\"' == ch2) {
                        sb.append(ch1);
                        sb.append(ch2);
                        i++;
                    } else {
                    	sb.append(ch1);
                        status = 3;
                    }
                } else {
                    sb.append(ch1);
                }
                break;
            case 3: //ダブルクォートの末尾
                if (',' == ch1) {
                    list.add(sb.toString());
                    sb = new StringBuffer();
                    status = 0;
                } else {
                    System.err.println("Ignore ch=" + ch1);
                }
            }
        }
        switch (status) {
        case 0:
            list.add(sb.toString());
            break;
        case 1:
            list.add(sb.toString());
            break;
        case 2:
            sb.append("\n");
            bContinue = true;
            break;
        case 3:
            list.add(sb.toString());
            break;
        }
        return bContinue;
    }
    
}
