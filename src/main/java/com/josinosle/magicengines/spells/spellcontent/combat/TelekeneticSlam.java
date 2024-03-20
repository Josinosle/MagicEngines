package com.josinosle.magicengines.spells.spellcontent.combat;

import com.josinosle.magicengines.MagicEngines;
import com.josinosle.magicengines.spells.spellcontent.SpellCastManaChanges;
import com.josinosle.magicengines.util.castgeometry.CastVector;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = MagicEngines.MOD_ID)
public class TelekeneticSlam {
    public TelekeneticSlam(Entity entity,ServerPlayer player) {

        SpellCastManaChanges logic = new SpellCastManaChanges();
        if (logic.spellCastable(player,1000)) {

            // change entity delta movement
            entity.setDeltaMovement(
                    entity.getX() - player.getX(),
                    entity.getY() - player.getY() + 0.2,
                    entity.getZ() - player.getZ());

            // send spawn particle
            player.getLevel().sendParticles(
                    ParticleTypes.EXPLOSION,
                    entity.getX(),
                    entity.getY() + 1,
                    entity.getZ(),
                    1,
                    0,
                    0.05,
                    0,
                    0);

            entity.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 2.0F);
        }

        //sub mana
        logic.subMana(player, 1000);

    }
}
