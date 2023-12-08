import java.util.Scanner;

abstract public class Character implements Character_interface
{
    private float[] stat1;
    //0 Max_HP
    //1 Max_mana
    //2 base_atk

    private float[] stat2;
    //0 current hp
    //1 currrent mana
    //2 atk after cal
    //3 def

    private boolean have_wing; //not have in lab4
    private boolean now_flying;

    private int lv;

    private String[] info;
    //0 name
    //1 job
    //2 species 
    //3 profile

    private Accessory[] equipment;
    // 0 armor
    // 1 armor pants
    // 2 Veil
    // 3 necklace
    // 4 ring
    // 5 bangle
    // 6 shoe

    private Item[] inventory;

    private Weapon weapon;
    private Weapon[] weapon_inventory;

    //private:
        private void use_item2(int size, int input)
        {
            if(input < 0 || input > size-1) System.out.println("\nInvalid input\n");
            else
            {
                inventory[input].use_item(stat1, stat2);
                
                if(inventory[input].return_count() == 0)
                {
                    Item[] new_inventory = new Item[size-1];
                    int new_index = 0;
                    for(int i = 0; i < size; i++)
                    {
                        if(i == input) continue;

                        new_inventory[new_index++] = inventory[i];
                    } 

                    inventory = new_inventory;
                }
                
            }
        }

    // public:
        //wait
        public Character(String[] info, int lv, boolean have_wing,  Accessory[] equipment, Weapon[] weapon_have, float[] stat)
        {
            this.info = info;
            this.lv = lv;
            this.have_wing = have_wing;
            this.equipment = equipment;
            weapon_inventory = weapon_have;
            stat1 = stat;

            if(equipment != null) 
            {
                for(Accessory i: equipment) i.equip(stat1, stat2);
            }
        }

        @Override
        public float normal_attack()
        {
            return (float) (weapon.return_atk() + stat2[2]);
        }

        @Override
        public void be_attack(float dmg)
        {
            float dmg_m_def = dmg;
            dmg_m_def -= stat2[3];
            if(dmg_m_def < 0) dmg_m_def = 0;
            stat2[1] -= dmg;
            System.out.println('\n'+info[0]+" be attacked with "+dmg+" dmg"+'\n');
        } 

        // astract
        @Override
        public float skill()
        {
            return 0;
        }

        @Override
        //astract
        public String talk(int text_order)
        {
            return "";
        }

        @Override
        //astract
        public void listen(String dialog)
        {

        }

        @Override
        //wait
        public void swap_weapon()
        {
            if(weapon_inventory.length > 1)
            {
                int input = -1;
                Scanner get = new Scanner(System.in);

                int size = weapon_inventory.length;
                for(int i = 0; i < size; i++)
                {
                    System.out.printf("(%d) %s",weapon_inventory[i].return_name());
                }

                System.out.println("\nChoose your weapon");

                if(get.hasNextInt()) input = get.nextInt();
                get.nextLine();

                if(input < 0 || input > size-1) System.out.println("\nCancel\n");
                else
                {
                    weapon = weapon_inventory[input];
                    System.out.printf("\nYour weapon change to %s\n",weapon.return_name());
                }

            }
            else System.out.println("\nYou can't change weapon");
        }

        @Override
        //wait
        public void equip_Accessory(Accessory equip)
        {
            // System.out.println("\nYou can't change your Accessory in the balle field\n");
        }

        @Override
        // wait
        public void unequip_Accessory()
        {
            int size = 0;

            if(equipment != null) size = equipment.length;

            if(size > 0)
            {
                System.out.println();
                for(int i = 0; i < size; i++)
                {
                    if(equipment[i] != null) System.out.printf("(%d) %s (type) %s\n",i,equipment[i].return_name(),equipment[i].return_type());
                } 
                System.out.println();

                int input = -1;
                Scanner get = new Scanner(System.in);
                
                if(get.hasNextInt()) input = get.nextInt();
                get.nextLine();

                if(input > size || input < 0) System.out.println("\nNot have this weapon");
                else System.out.println("\nCan't unequip during the battle");
            }
            else System.out.println("You not have any equipment");
        }

        @Override
        //wait
        public void check_inventory() 
        {
            if(inventory != null)
            {
                System.out.println();
                for(Item i: inventory) System.out.printf("%s x%d\n",i.info(),i.return_count());
                System.out.println();

            }
            else System.out.println("\nYour inventory is Empty\n");
        }

        @Override
        public void use_item() 
        {
            int size = 0;
            if(inventory != null) size = inventory.length;

            System.out.println();

            if(size != 0)
            {
                int input = -1;
                Scanner get = new Scanner(System.in);

                System.out.println();
                for(int i = 0; i<size; i++) System.out.printf("(%d) : %s x%d",i,inventory[i].info(),inventory[i].return_count());
                System.out.println();

                System.out.println("Choose item : ");
                if(get.hasNextInt()) input = get.nextInt();
                get.nextLine();

                use_item2(size, input);
            }
            else System.out.println("\nYou have nothing in your inventory\n");
        }

        @Override
        public void fly()
        {
            if(!have_wing) System.out.println("\nYou can't fly\n");
            // else if(have_wing && !now_flying) now_flying = true;
            else if(have_wing && now_flying) System.out.println("\nyou are flying\n");
            else
            {
                now_flying = true;
                System.out.println("\nyou are flying into the sky\n");
            }
        }
}
