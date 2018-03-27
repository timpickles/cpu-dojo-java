package dojo.cpu;

public class CPU {
    public int a = 0;
    public int programCounter = 0;
    public int[] memory = new int[16];

    public void loadProgram(int[] program) {
        System.arraycopy(program, 0, memory, 0, program.length);
    }
    
    private int nextProgramCounter() {
        return programCounter++;
    }

    public void start() {
        while (memory[programCounter] != 0) {
            switch (memory[nextProgramCounter()]) {
                // LDA - Load value to register A
                case 1:
                    a = memory[nextProgramCounter()];
                    break;

                // ADC - Add value to register A
                case 2:
                    a += memory[nextProgramCounter()];
                    break;

                // STA - Store value of register A in memory
                case 3:
                    memory[memory[nextProgramCounter()]] = a;
                    break;
            }
        }
    }
}
