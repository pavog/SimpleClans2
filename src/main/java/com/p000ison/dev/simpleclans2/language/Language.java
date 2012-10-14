package com.p000ison.dev.simpleclans2.language;

import com.p000ison.dev.simpleclans2.util.Logging;
import org.bukkit.ChatColor;

import java.io.File;
import java.text.MessageFormat;
import java.util.logging.Level;

public class Language {
    private static LanguageMap defaultBundle;
    private static LanguageMap bundle;
    private static final String DEFAULT_FILE_NAME = "lang.properties";

    public static void setInstance(File folder)
    {
        defaultBundle = new LanguageMap("/languages/" + DEFAULT_FILE_NAME, true);
        defaultBundle.load();
        bundle = new LanguageMap(new File(folder, DEFAULT_FILE_NAME).getAbsolutePath(), false);
        bundle.setDefault(defaultBundle);
        bundle.load();
        bundle.save();
    }

    public static String getTranslation(String key, Object... args)
    {
        String bundleOutput = bundle.getValue(key);

        if (bundleOutput == null) {
            Logging.debug(ChatColor.RED + "The language for the key %s was not found!", Level.WARNING, key);

            if (defaultBundle != null) {
                String defaultBundleOutput = defaultBundle.getValue(key);
                if (defaultBundleOutput == null) {
                    Logging.debug(ChatColor.RED + "The language for the key %s was not found in the default bundle!", Level.WARNING, key);
                    return "Error!";
                }

                if (args.length > 0) {
                    return MessageFormat.format(defaultBundleOutput, args);
                }
                return defaultBundleOutput;
            }

            return "Error!";
        }

        if (args.length > 0) {
            return MessageFormat.format(bundleOutput, args);
        }
        return bundleOutput;
    }

    public static void clear()
    {
        bundle.clear();
        defaultBundle.clear();

        defaultBundle = null;
        bundle = null;
    }
}