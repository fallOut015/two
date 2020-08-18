//function initializeCoreMod() {
//	return {
//		'potion': {
//			'target': {
//				'type': 'CLASS',
//				'name': 'net.minecraft.entity.player.PlayerAbilities'
//			},
//			'transformer': function(classNode) {
//				var asmapi=Java.type('net.minecraftforge.coremod.api.ASMAPI')
//				var fn = asmapi.mapField('walkSpeed')
//				asmapi.redirectFieldToMethod(classNode, fn, null)
//				return classNode;
//			}
//		}
//	}
//}