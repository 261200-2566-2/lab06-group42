public class Weapon 
{
    private String name;
    private float atk;

    // public:
        public Weapon()
        {

        }

        public String return_name()
        {
            return name;
        }

        public float return_atk()
        {
            return atk;
        }

        //astract
        public float skill()
        {
            return 0;
        }
}