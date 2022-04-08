package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

/*_------------------------------CLASS LASER-----------------------
 * 
 * ATTRIBUT DE LA CLASS:
 * 		-Direction direction;
 * 
 * MÉTHODE DE CLASS
 * 		-toString()
 * 			>retourne affichage
 */

public class Laser implements Serializable{
	
/*-----------------------ATTRIBUT--------------------------*/
	protected Direction direction;

	
/*----------------------CONSTRUCTEUR---------------------*/
	public Laser(Direction direction) {
			this.direction=direction;
		}

/*-------------------------FONCTION--------------------*/
	public String toString() {
		return "Laser [direction=" + direction + "]";
	}

	}
