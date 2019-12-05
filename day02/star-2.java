public class HelloWorld{

     public static void main(String []args){
        System.out.println("Starting");

        Intcode intcode = new Intcode();

        int target = 19690720;

        for(int noun = 0; noun < 100; noun++) {
            for(int verb = 0; verb < 100; verb++) {
                int result = intcode.execute(new int[] {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,6,19,23,2,23,6,27,2,6,27,31,2,13,31,35,1,10,35,39,2,39,13,43,1,43,13,47,1,6,47,51,1,10,51,55,2,55,6,59,1,5,59,63,2,9,63,67,1,6,67,71,2,9,71,75,1,6,75,79,2,79,13,83,1,83,10,87,1,13,87,91,1,91,10,95,2,9,95,99,1,5,99,103,2,10,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0}, noun,verb);

                if(target == result) {
                    System.out.println("Found match, noun=" + noun + ", verb=" + verb + ", answer=" + (100 * noun + verb));
                    return;
                }
            }
        }

     }
}

class Intcode {

    public int execute(int []code, int noun, int verb) {

        int position = 0;

        // Task requirements
        code[1] = noun;
        code[2] = verb;

        while(position < code.length) {

            switch(code[position]) {
                case 1:
                    code[code[position + 3]] = code[code[position + 2]] + code[code[position + 1]];
                    position += 4;
                    break;

                case 2:
                    code[code[position + 3]] = code[code[position + 2]] * code[code[position + 1]];
                    position += 4;
                    break;


                case 99:
                    return code[0];

                default:
                    throw new NullPointerException("Invalid position");
            }
        }

        return code[0];
    }
}
