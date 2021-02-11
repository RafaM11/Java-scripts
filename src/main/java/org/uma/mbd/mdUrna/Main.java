package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try {
            int nBl = Integer.parseInt(args[0]);
            int nNg = Integer.parseInt(args[1]);
            Urna u = new Urna(nBl, nNg);
            while (u.totalBolas() > 1) {
                Urna.ColorBola b1 = u.extraerBola();
                Urna.ColorBola b2 = u.extraerBola();
                if (b1 == b2) {
                    u.ponerBlanca();
                } else {
                    u.ponerNegra();
                }
            }
            System.out.println(u.extraerBola());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Deben ponerse dos argumentos");
        } catch (NumberFormatException e) {
            System.out.println("Error: Los argumentos deben ser numéricos");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
            /* La excepción Runtime Exception la ponemos la última porque engloba a las anteriores (son hijas suyas) */
        } catch (RuntimeException e) {
            System.out.println("Cualquier otra excepción");
        }
        }
}