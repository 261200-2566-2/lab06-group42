public class Text
{
    private String[] MC_Dialog;

    private String[] mc_info = 
    {
        "Serena",
        "Archer Hero",
        "Human?",
        "Despite being one of the four heroes in this world, she was one of \nthe evil leaders in the world she originated from."
    };

    private String[] enemy_info = 
    {
        "Monika",
        "The evil leader from another world?",
        "Succubus",
        "She has lived with Selena since she was a child.\nAlthough she is stubborn with Serena, she loves Serena more than anyone else in her world.\nbut now she was controlled by the evil king in this world."
    };

    private String[] serena

    // public:


    public static void main(String[] args) 
    {
        Text test = new Text();
        System.out.println(test.mc_info[3]);    
        System.out.println();
        System.out.println(test.enemy_info[3]);
    }
    
}
