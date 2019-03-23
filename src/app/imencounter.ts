import { IMMonster } from './immonster';
import { Turn } from './turn';
import { IMCharacter } from './imcharacter';

export class IMEncounter {
    constructor(
        public monsterArray: Array<IMMonster>,
        public characterArray: Array<IMCharacter>,
        public turn: Turn
    ) { }

    addMonster(monster: IMMonster) {
        this.monsterArray.push(monster);
    }

    addCharacter(character: IMCharacter) {
        this.characterArray.push(character);
    }
    
}
