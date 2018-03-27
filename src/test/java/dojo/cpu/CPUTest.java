package dojo.cpu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CPUTest {

    private CPU cpu;
    private int[] program = new int[] {1,100,2,7,3,15,0};

    @Before
    public void setup() {
        cpu = new CPU();
    }

    @Test
    public void shouldLoadProgramIntoCPU() {
        cpu.loadProgram(program);

        int[] expected = new int[] {1,100,2,7,3,15,0,0,0,0,0,0,0,0,0,0};

        Assert.assertArrayEquals(expected, cpu.memory);
    }

    @Test
    public void shouldLoad100IntoRegisterA() {
        cpu.loadProgram(new int[] {1,100});
        cpu.start();

        Assert.assertEquals(100, cpu.a);
    }

    @Test
    public void shouldAddValueToRegisterA() {
        cpu.loadProgram(new int[] {2,7});
        cpu.a = 100;
        cpu.start();

        Assert.assertEquals(107, cpu.a);
    }

    @Test
    public void shouldStoreRegisterValueInMemoryLocation() {
        cpu.loadProgram(new int[] {3,15});
        cpu.a = 107;
        cpu.start();

        Assert.assertEquals(107, cpu.memory[15]);
    }

    @Test
    public void shouldExecuteEntireProgram() {
        cpu.loadProgram(program);
        cpu.start();

        Assert.assertEquals(107, cpu.memory[15]);
    }
}
