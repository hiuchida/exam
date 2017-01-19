package wrapper;

import java.util.Comparator;

public class ByteArrayComparator implements Comparator<byte[]> {
	public int compare(byte[] o1, byte[] o2) {
        int n = Math.min(o1.length, o2.length);
        for (int i = 0; i < n; i++) {
            int cmp = Byte.compare(o1[i], o2[i]);
            if (cmp != 0)
                return cmp;
        }
        return o1.length - o2.length;
	}
}
