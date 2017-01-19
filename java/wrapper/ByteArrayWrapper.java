package wrapper;

import java.util.Arrays;

public class ByteArrayWrapper implements Comparable<ByteArrayWrapper> {
	private byte[] data;

	public ByteArrayWrapper(byte... data) {
		this.data = data.clone();
	}

	public boolean equals(Object other) {
		if (other instanceof ByteArrayWrapper) {
			return equals(((ByteArrayWrapper) other).data);
		}
		return false;
	}
	
	public boolean equals(byte[] other) {
		return Arrays.equals(data, other);
	}
	
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    public int compareTo(ByteArrayWrapper that) {
		int n = Math.min(this.data.length, that.data.length);
		for (int i = 0; i < n; i++) {
			int cmp = Byte.compare(this.data[i], that.data[i]);
            if (cmp != 0)
                return cmp;
		}
		return this.data.length - that.data.length;
	}
}
