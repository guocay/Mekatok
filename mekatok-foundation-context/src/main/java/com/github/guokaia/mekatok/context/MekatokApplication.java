package com.github.guokaia.mekatok.context;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * Mekatok 框架中对 SpringApplication 对象的包装. <br/>
 * 除封装了一些启动时的逻辑外,没做任何改变.<br/>
 * <li>修改启动时打印的Banner.</li>
 * <li>记录启动时应用服务的PID信息到文件.</li>
 * @author GuoKai
 */
public class MekatokApplication extends SpringApplication {

    /**
     * Banner 打印对象
     */
    private static final Banner BANNER = (environment, sourceClass, out) -> {
        out.println(
            AnsiOutput.toString(
                AnsiColor.BRIGHT_GREEN,
                "\n",
                "MMMMMMMM               MMMMMMMM                    kkkkkkkk                                      tttt                           kkkkkkkk\n",
                "M:::::::M             M:::::::M                    k::::::k                                   ttt:::t                           k::::::k\n",
                "M::::::::M           M::::::::M                    k::::::k                                   t:::::t                           k::::::k\n",
                "M:::::::::M         M:::::::::M                    k::::::k                                   t:::::t                           k::::::k\n",
                "M::::::::::M       M::::::::::M    eeeeeeeeeeee     k:::::k    kkkkkkk  aaaaaaaaaaaaa   ttttttt:::::ttttttt       ooooooooooo    k:::::k    kkkkkkk\n",
                "M:::::::::::M     M:::::::::::M  ee::::::::::::ee   k:::::k   k:::::k   a::::::::::::a  t:::::::::::::::::t     oo:::::::::::oo  k:::::k   k:::::k\n",
                "M:::::::M::::M   M::::M:::::::M e::::::eeeee:::::ee k:::::k  k:::::k    aaaaaaaaa:::::a t:::::::::::::::::t    o:::::::::::::::o k:::::k  k:::::k\n",
                "M::::::M M::::M M::::M M::::::Me::::::e     e:::::e k:::::k k:::::k              a::::a tttttt:::::::tttttt    o:::::ooooo:::::o k:::::k k:::::k\n",
                "M::::::M  M::::M::::M  M::::::Me:::::::eeeee::::::e k::::::k:::::k        aaaaaaa:::::a       t:::::t          o::::o     o::::o k::::::k:::::k\n",
                "M::::::M   M:::::::M   M::::::Me:::::::::::::::::e  k:::::::::::k       aa::::::::::::a       t:::::t          o::::o     o::::o k:::::::::::k\n",
                "M::::::M    M:::::M    M::::::Me::::::eeeeeeeeeee   k:::::::::::k      a::::aaaa::::::a       t:::::t          o::::o     o::::o k:::::::::::k\n",
                "M::::::M     MMMMM     M::::::Me:::::::e            k::::::k:::::k    a::::a    a:::::a       t:::::t    tttttto::::o     o::::o k::::::k:::::k\n",
                "M::::::M               M::::::Me::::::::e          k::::::k k:::::k   a::::a    a:::::a       t::::::tttt:::::to:::::ooooo:::::ok::::::k k:::::k\n",
                "M::::::M               M::::::M e::::::::eeeeeeee  k::::::k  k:::::k  a:::::aaaa::::::a       tt::::::::::::::to:::::::::::::::ok::::::k  k:::::k\n",
                "M::::::M               M::::::M  ee:::::::::::::e  k::::::k   k:::::k  a::::::::::aa:::a        tt:::::::::::tt oo:::::::::::oo k::::::k   k:::::k\n",
                "MMMMMMMM               MMMMMMMM    eeeeeeeeeeeeee  kkkkkkkk    kkkkkkk  aaaaaaaaaa  aaaa          ttttttttttt     ooooooooooo   kkkkkkkk    kkkkkkk\n"
            )
        );
    };

    public MekatokApplication(Class<?>... primarySources) {
        this(null, primarySources);
    }

    public MekatokApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
        super(resourceLoader, primarySources);
        afterPropertiesSet();
    }

    /**
     * 启动函数, 对SpringApplication.run()的包装.
     */
    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class<?>[] { primarySource }, args);
    }

    /**
     * 启动函数, 对SpringApplication.run()的包装.
     */
    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        return new MekatokApplication(primarySources).run(args);
    }

    /**
     * 设置增强应用信息
     */
    private void afterPropertiesSet(){
        // 设置Banner
        setBanner(BANNER);
        // 设置 PidFileWriter 的监听
        addListeners(new ApplicationPidFileWriter());
    }

}
