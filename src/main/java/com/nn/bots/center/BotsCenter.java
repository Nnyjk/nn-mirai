package com.nn.bots.center;

import com.nn.bots.entity.LoginInfo;
import jakarta.inject.Singleton;
import kotlin.coroutines.Continuation;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.auth.BotAuthorization;
import net.mamoe.mirai.utils.BotConfiguration;
import net.mamoe.mirai.utils.LoginSolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author yangxiao
 * @since V1.0.0 2024/07/15
 */
@Singleton
public class BotsCenter {

    public List<Bot> bots() {
        return Bot.getInstances();
    }

    public Bot bot(Long id) {
        return Bot.getInstances().stream().filter(b -> b.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Bot not found"));
    }

    public Bot androidBot(LoginInfo loginInfo) {
        return BotFactory.INSTANCE.newBot(loginInfo.getQq(), loginInfo.getPassword(), configuration -> {
            configuration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_PHONE);
        });
    }

    public Bot watchBot(LoginInfo loginInfo) {
        Bot bot = BotFactory.INSTANCE.newBot(loginInfo.getQq(), BotAuthorization.byQRCode(), configuration -> {
            configuration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_WATCH);
        });
        return bot;
    }

    public void login(Long id) {
        Bot bot = Bot.getInstance(id);
//        if (!BotConfiguration.MiraiProtocol.ANDROID_WATCH.equals(bot.getConfiguration().getProtocol())) {
//            bot.login();
//            return;
//        }
//        // TODO 二维码登录返回至调用处
//        LoginSolver loginSolver =  bot.getConfiguration().getLoginSolver();
//        if (null == loginSolver) {
//            loginSolver = new LoginSolver() {
//                @Override
//                public @Nullable Object onSolveSliderCaptcha(@NotNull Bot bot, @NotNull String s, @NotNull Continuation<? super String> continuation) {
//                    return null;
//                }
//
//                @Override
//                public @Nullable Object onSolvePicCaptcha(@NotNull Bot bot, @NotNull byte[] bytes, @NotNull Continuation<? super String> continuation) {
//                    return null;
//                }
//            };
//        }
        bot.login();
    }
}
