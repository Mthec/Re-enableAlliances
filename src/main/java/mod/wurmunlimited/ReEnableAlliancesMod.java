package mod.wurmunlimited;

import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.util.logging.Logger;

public class ReEnableAlliancesMod implements WurmServerMod, Initable {
    private static final Logger logger = Logger.getLogger(ReEnableAlliancesMod.class.getName());

    @Override
    public void init() {
        HookManager manager = HookManager.getInstance();

        //noinspection SuspiciousInvocationHandlerImplementation
        manager.registerHook("com.wurmonline.server.questions.KingdomStatusQuestion",
                "mayAlly",
                "(B)Z",
                () -> (proxy, method, args) -> true);
    }
}
