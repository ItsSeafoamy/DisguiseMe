package me.laxynd.disguiseme;

public class DataType {
	
	public static final int BYTE = 0;
	public static final int VARINT = 1;
	public static final int FLOAT = 2;
	public static final int STRING = 3;
	public static final int CHAT = 4;
	public static final int SLOT = 5;
	public static final int BOOLEAN = 6;
	public static final int VECTOR3F = 7;
	public static final int POSITION = 8;
	public static final int OPT_POSITION = 9;
	public static final int DIRECTION = 10;
	public static final int OPT_UUID = 11;
	public static final int BLOCK_ID = 12;
	
	public static Class<?> getClass(int type){
		if (type == BYTE) return Byte.class;
		else if (type == VARINT) return Integer.class;
		else if (type == FLOAT) return Float.class;
		else if (type == STRING) return String.class;
		else if (type == CHAT) return String.class;
		else if (type == BOOLEAN) return Byte.class;
		else return null;
	}
}