package com.alison.base.object;

import java.util.Arrays;

public class StringD {
	private int hash;
	private final int count;
	private final int offset;
	private final char value[];

	public StringD() {
		this.offset = 0;
		this.count = 0;
		this.value = new char[0];
	}

	public StringD(StringD original) {
		int size = original.count;
		char[] originalValue = original.value;
		char[] v;
		if (originalValue.length > size) {
			int off = original.offset;
			v = Arrays.copyOfRange(originalValue, off, off + size);
		} else {
			v = originalValue;
		}
		this.offset = 0;
		this.count = size;
		this.value = v;
	}

	public int length() {
		return count;
	}

	public char charAt(int index) {
		if ((index < 0) || (index >= count)) {
			throw new StringIndexOutOfBoundsException(index);
		}
		return value[index + offset];
	}

	public int hashCode() {
		int hash = 0;
		if (hash == 0 && length() > 0) {
			for (int i = 0; i < length(); i++) {
				hash = 31 * hash + charAt(i);
			}
		}
		return hash;
	}

	// orig String hashCode
	public int hashCode2() {
		int h = hash;
		int len = count;
		if (h == 0 && len > 0) {
			int off = offset;
			char val[] = value;

			for (int i = 0; i < len; i++) {
				h = 31 * h + val[off++];
			}
			hash = h;
		}
		return h;
	}

	// toString

}
