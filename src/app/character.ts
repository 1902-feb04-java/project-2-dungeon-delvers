export class Character {
    constructor(
        public id: number,
        public playerAccount: number,
        
        public characterName: string,

        public campaignId: number,
        
        public healthPoints: number,
        public armorClass: number,
        public damageDie: number,
        
    ) {}
}
