public interface Character_interface 
{
    float skill();
    float normal_attack();
    String talk(int text_order); //change form lab4
    void listen(String input);
    void be_attack(float dmg); //change to void
    void fly();
    void swap_weapon();
    void equip_Accessory(Accessory equip); //not the same at lab4
    void unequip_Accessory();//not the same at lab4
    void use_item();
    void check_inventory();
}
