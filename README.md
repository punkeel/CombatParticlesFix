# Combat Particles Fix

This mod fixesthe wonky behavior introduced in Minecraft 1.8.4 that displays critical particles
(blue for sharpness, white on critical hit) client side, when this should be handled server-side. And this **IS** handled
server side! Hence the particles are displayed twice.

This mod is compatible and tested with Forge 1.8, 1.9, 1.10, 1.11 and 1.12

The code itself is quite simple as it relies on the `AttackEntityEvent` event, called right before the particles are 
displayed. 

**Without the mod, this happens:**
![](demo.gif)

**This is when hitting a static entity. Imagine how this feels during a combat!**


## Downloads
[ParticlesFix-1.0.jar](https://github.com/PunKeel/CombatParticlesFix/releases/download/v1.0/ParticlesFix-1.0.jar)

## Plugin Message Channel
The mod register a `Plugin Message` channel, `ParticlesFix`. Servers are able to disable the behaviour of this mod by
sending this byte message: `new byte[]{0x00, 0x00};`.
The first `0x00` is the discriminator (the message's ID), the second one is the byte representation of `false`.

## Disclaimer
Use this mod at your own risk.