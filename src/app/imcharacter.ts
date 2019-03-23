export class IMCharacter {

    public type: string = "PC"; //not on Character

    constructor(
        // from the Character object. keeping this info
        public id: number,
        public playerAccount: number,
        public campaignId: number,
        // from the IMMonster object, the names are different between this and Character
        public name: string, //characterName in Character
        public hp: number, //healthPoints
        public ac: number, //armorClass
        public damageDie: number, //same
        
    ) {}
}
