package com.HitDelayWithBuff;

import org.bukkit.command.*;
import org.bukkit.entity.Player;


public class MainCommand
    implements CommandExecutor
{

    public MainCommand(MainClass instance)
    {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
        if(sender instanceof Player)
        {
            Player player = (Player)sender;
            if(player.isOp())
            {
                if(args.length > 0)
                {
                    if(args[0].equalsIgnoreCase("debug"))
                    {
                        plugin.isDebug = !plugin.isDebug;
                        if(plugin.isDebug)
                            player.sendMessage("\2472[\247aHitDelayWithBuff\2472] \2477\uB514\uBC84\uADF8 \uD65C\uC131\uD654. \uCF58\uC194\uC5D0\uC11C \uD2F1\uC744 \uD655\uC778\uD569\uB2C8\uB2E4.");
                        else
                            player.sendMessage("\2472[\247aHitDelayWithBuff\2472] \2477\uB514\uBC84\uADF8 \uBE44\uD65C\uC131\uD654. \uCF58\uC194\uC5D0\uC11C \uD2F1\uC744 \uD655\uC778\uD569\uB2C8\uB2E4.");
                    } else
                    if(args[0].equalsIgnoreCase("default"))
                    {
                        if(args.length == 2)
                        {
                            if(plugin.defaultTicks >= plugin.minimumTicks && plugin.defaultTicks <= plugin.maximumTicks)
                            {
                                plugin.defaultTicks = Integer.parseInt(args[1]);
                                sender.sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uAE30\uBCF8 \uD53C\uACA9 \uB51C\uB808\uC774\uAC00 ")).append(plugin.defaultTicks).append("\uD2F1\uC774 \uB418\uC5C8\uC2B5\uB2C8\uB2E4.").toString());
                            } else
                            {
                                sender.sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uB108\uBB34 \uC801\uAC70\uB098 \uB9CE\uC2B5\uB2C8\uB2E4. (")).append(plugin.minimumTicks).append(" \uC774\uC0C1 ").append(plugin.maximumTicks).append("\uC774\uD558)").toString());
                            }
                        } else
                        {
                            sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uC785\uB825\uB418\uC9C0 \uC54A\uC558\uC2B5\uB2C8\uB2E4.");
                        }
                    } else
                    if(args[0].equalsIgnoreCase("add"))
                    {
                        if(args.length == 2)
                        {
                            if(plugin.addTicks >= 0)
                            {
                                plugin.addTicks = Integer.parseInt(args[1]);
                                sender.sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uD53C\uB85C \uB808\uBCA8 1\uB2F9 \uCD94\uAC00 \uD53C\uACA9 \uB51C\uB808\uC774\uAC00 ")).append(plugin.addTicks).append("\uD2F1\uC774 \uB418\uC5C8\uC2B5\uB2C8\uB2E4.").toString());
                            } else
                            {
                                sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uB108\uBB34 \uC801\uC2B5\uB2C8\uB2E4. (0 \uC774\uC0C1)");
                            }
                        } else
                        {
                            sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uC785\uB825\uB418\uC9C0 \uC54A\uC558\uC2B5\uB2C8\uB2E4.");
                        }
                    } else
                    if(args[0].equalsIgnoreCase("sub"))
                    {
                        if(args.length == 2)
                        {
                            if(plugin.subTicks >= 0)
                            {
                                plugin.subTicks = Integer.parseInt(args[1]);
                                sender.sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uC131\uAE09\uD568 \uB808\uBCA8 1\uB2F9 \uC81C\uAC70 \uD53C\uACA9 \uB51C\uB808\uC774\uAC00 ")).append(plugin.subTicks).append("\uD2F1\uC774 \uB418\uC5C8\uC2B5\uB2C8\uB2E4.").toString());
                            } else
                            {
                                sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uB108\uBB34 \uC801\uC2B5\uB2C8\uB2E4. (0 \uC774\uC0C1)");
                            }
                        } else
                        {
                            sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uC785\uB825\uB418\uC9C0 \uC54A\uC558\uC2B5\uB2C8\uB2E4.");
                        }
                    } else
                    if(args[0].equalsIgnoreCase("maximum"))
                    {
                        if(args.length == 2)
                        {
                            if(plugin.maximumTicks >= plugin.minimumTicks)
                            {
                                plugin.maximumTicks = Integer.parseInt(args[1]);
                                sender.sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uCD5C\uB300 \uD53C\uACA9 \uB51C\uB808\uC774\uAC00 ")).append(plugin.maximumTicks).append("\uD2F1\uC774 \uB418\uC5C8\uC2B5\uB2C8\uB2E4.").toString());
                            } else
                            {
                                sender.sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uB108\uBB34 \uC801\uC2B5\uB2C8\uB2E4. (")).append(plugin.minimumTicks).append(" \uC774\uC0C1)").toString());
                            }
                        } else
                        {
                            sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uC785\uB825\uB418\uC9C0 \uC54A\uC558\uC2B5\uB2C8\uB2E4.");
                        }
                    } else
                    if(args[0].equalsIgnoreCase("minimum"))
                    {
                        if(args.length == 2)
                        {
                            if(plugin.minimumTicks >= 0)
                            {
                                plugin.minimumTicks = Integer.parseInt(args[1]);
                                sender.sendMessage((new StringBuilder("\2472[\247aHitDelayWithBuff\2472] \2477\uCD5C\uC18C \uD53C\uACA9 \uB51C\uB808\uC774\uAC00 ")).append(plugin.minimumTicks).append("\uD2F1\uC774 \uB418\uC5C8\uC2B5\uB2C8\uB2E4.").toString());
                            } else
                            {
                                sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uB108\uBB34 \uC801\uC2B5\uB2C8\uB2E4. (0 \uC774\uC0C1)");
                            }
                        } else
                        {
                            sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uAC12\uC774 \uC785\uB825\uB418\uC9C0 \uC54A\uC558\uC2B5\uB2C8\uB2E4.");
                        }
                    } else
                    {
                        sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uC54C \uC218 \uC5C6\uB294 \uCEE4\uB9E8\uB4DC \uC785\uB2C8\uB2E4.");
                        sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c/hitdelay\uB97C \uD1B5\uD574 \uCEE4\uB9E8\uB4DC\uB97C \uD655\uC778\uD558\uC138\uC694.");
                    }
                } else
                {
                    sender.sendMessage("\2472[\247aHitDelayWithBuff\2472]");
                    sender.sendMessage("\2476/hitdelay debug \247f - \247a\uB514\uBC84\uADF8 \uC635\uC158\uC744 \uC124\uC815\uD569\uB2C8\uB2E4.");
                    sender.sendMessage("\2476/hitdelay default [ticks]\247f - \247a\uAE30\uBCF8 \uD53C\uACA9 \uB51C\uB808\uC774\uB97C \uC124\uC815\uD569\uB2C8\uB2E4.");
                    sender.sendMessage("\2476/hitdelay add [ticks]\247f - \247a\uD53C\uB85C \uB808\uBCA8 1\uB2F9 \uB298\uC5B4\uB098\uB294 \uD53C\uACA9 \uB51C\uB808\uC774\uB97C \uC124\uC815\uD569\uB2C8\uB2E4.");
                    sender.sendMessage("\2476/hitdelay sub [ticks]\247f - \247a\uC131\uAE09\uD568 \uB808\uBCA8 1\uB2F9 \uC904\uC5B4\uB4DC\uB294 \uD53C\uACA9 \uB51C\uB808\uC774\uB97C \uC124\uC815\uD569\uB2C8\uB2E4.");
                    sender.sendMessage("\2476/hitdelay maximum [ticks]\247f - \247a\uCD5C\uB300 \uD53C\uACA9 \uB51C\uB808\uC774\uB97C \uC124\uC815\uD569\uB2C8\uB2E4.");
                    sender.sendMessage("\2476/hitdelay minimum [ticks]\247f - \247a\uCD5C\uC18C \uD53C\uACA9 \uB51C\uB808\uC774\uB97C \uC124\uC815\uD569\uB2C8\uB2E4.");
                }
                return true;
            } else
            {
                sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uBA85\uB839\uC5B4\uB97C \uC2E4\uD589\uD560 \uAD8C\uD55C\uC774 \uC5C6\uC2B5\uB2C8\uB2E4.");
                return false;
            }
        } else
        {
            sender.sendMessage("\2472[\247aHitDelayWithBuff\2472] \247c\uCF58\uC194\uC5D0\uC11C\uB294 \uBA85\uB839\uC5B4\uB97C \uC0AC\uC6A9\uD558\uC2E4 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.");
            return false;
        }
    }

    private final MainClass plugin;
}
