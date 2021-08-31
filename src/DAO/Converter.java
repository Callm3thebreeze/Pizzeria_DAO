package DAO;
import java.nio.ByteBuffer;
import java.util.UUID;

public class Converter {
    public static byte[] fromUUIDtoByteArray(UUID id){

        byte[] uuidBytes = new byte[16];
            ByteBuffer.wrap(uuidBytes)
                .putLong(id.getMostSignificantBits())
                .putLong(id.getLeastSignificantBits());

        return uuidBytes;
    }

    public static UUID fromByteArrayToUUID(byte[] bytes){

        ByteBuffer bb = ByteBuffer.wrap(bytes);
        UUID uuid = new UUID(bb.getLong(), bb.getLong());

        return uuid;
    }
}
