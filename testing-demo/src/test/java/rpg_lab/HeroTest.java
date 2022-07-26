package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    // Example of stubbed implementation of Weapon just for tests
    private static class FakeWeapon implements Weapon {
        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {
        }
    }

    @Test
    public void test_HeroGainsXP_When_KillingTarget() {
        Hero hero = new Hero("Javarcho", new FakeWeapon());

        assertEquals(0, hero.getExperience());

        // Example of anonymous class instance of Target just to fake giveExperience() and isDead()
        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 200;
            }

            @Override
            public Boolean isDead() {
                return true;
            }
        };

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }

    @Test
    public void test_HeroGainsXP_When_KillingTarget_Mocking_Example() {
        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Javarcho", weapon);

        assertEquals(0, hero.getExperience());

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(200);

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }

    @Test
    public void test_HeroGainsXP_When_KillingTarget_Real_Objects_Example() {
        Weapon weapon = new Axe(13, 42);

        Hero hero = new Hero("Javarcho", weapon);

        assertEquals(0, hero.getExperience());

        Target target = new Dummy(13, 200);

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }

}