package mod.drinking.my.sipcount;
import mod.drinking.my.client.ClientSipData;
import net.minecraft.nbt.CompoundTag;
public class PlayerSips {
    private int sips;
    private int totalSips;
<<<<<<< Updated upstream
=======
    private int sipTimer;
>>>>>>> Stashed changes
    private final int MIN_SIPS = 0;

    public int get_sips(){
        return sips;
    }

    public int get_totalSips() {return totalSips; }

<<<<<<< Updated upstream
    public void add_sips(int add){
        sips = Math.max(sips + add, MIN_SIPS);
        totalSips = Math.max(totalSips + add, MIN_SIPS);
        ClientSipData.set(sips, totalSips);
=======
    public int get_timer(){
        return sipTimer;
    }

    public void dec_timer(){
        sipTimer--;
    }

    public void add_sips(int add){
        sips = Math.max(sips + add, MIN_SIPS);
        totalSips = Math.max(totalSips + add, MIN_SIPS);
        sipTimer = 20;
>>>>>>> Stashed changes
    }

    public void set_sips(int setsips, int settotalsips){
        sips = setsips;
        totalSips = settotalsips;
    }

    public void reset_sips(){
        sips = MIN_SIPS;
        ClientSipData.set(sips, totalSips);
    }

    public void reset_total_sips(){totalSips = MIN_SIPS; }

    public void copyFrom(PlayerSips source){
        this.sips = source.sips;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("sips", sips);
        nbt.putInt("totalSips", totalSips);
    }

    public void loadNBTData(CompoundTag nbt){
        sips = nbt.getInt("sips");
        totalSips = nbt.getInt("totalSips");
    }
}
