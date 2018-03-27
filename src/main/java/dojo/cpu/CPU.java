package dojo.cpu;

public class CPU {
    public int a = 0;
    public int programCounter = 0;
    public int[] memory = new int[16];

    public void loadProgram(int[] program) {
        System.arraycopy(program, 0, memory, 0, program.length);
    }

    public void start() {
        while (memory[programCounter] != 0) {
            switch (memory[programCounter]) {
                case 1:
                    a = memory[programCounter+1];
                    programCounter += 2;
                    break;

                case 2:
                    a += memory[programCounter+1];
                    programCounter += 2;
                    break;

                case 3:
                    memory[memory[programCounter+1]] = a;
                    programCounter += 2;
                    break;

                default:
                    programCounter++;
            }
        }
    }
}
