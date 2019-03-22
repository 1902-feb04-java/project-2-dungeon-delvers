import { IMMonster } from './immonster';
import { Turn } from './turn';

export class IMEncounter {
    constructor(
        public monsterArray: Array<IMMonster>,
        public turn: Turn
    ) { }
}
