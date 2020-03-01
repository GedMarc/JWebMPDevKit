/*
 * Copyright (C) 2009-2017 the original author(s).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.jansi.internal;

import static org.fusesource.hawtjni.runtime.FieldFlag.CONSTANT;
import static org.fusesource.hawtjni.runtime.MethodFlag.CONSTANT_INITIALIZER;

import static org.fusesource.hawtjni.runtime.ArgFlag.*;

import org.fusesource.hawtjni.runtime.ArgFlag;
import org.fusesource.hawtjni.runtime.ClassFlag;
import org.fusesource.hawtjni.runtime.JniArg;
import org.fusesource.hawtjni.runtime.JniClass;
import org.fusesource.hawtjni.runtime.JniField;
import org.fusesource.hawtjni.runtime.JniMethod;
import org.fusesource.hawtjni.runtime.Library;

/**
 * Interface to access some low level POSIX functions.
 * 
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
@JniClass()
public class CLibrary {
    
    private static final Library LIBRARY = new Library("jansi", CLibrary.class);    
    static {
        LIBRARY.load();
        init();
    }

    @JniMethod(flags={CONSTANT_INITIALIZER})
    private static native void init();

    @JniField(flags={CONSTANT}, conditional="defined(STDIN_FILENO)")
    public static int STDIN_FILENO;
    @JniField(flags={CONSTANT}, conditional="defined(STDOUT_FILENO)")
    public static int STDOUT_FILENO;
    @JniField(flags={CONSTANT}, conditional="defined(STDERR_FILENO)")
    public static int STDERR_FILENO;

    @JniField(flags={CONSTANT}, accessor="1", conditional="defined(HAVE_ISATTY)")
    public static boolean HAVE_ISATTY;

    @JniField(flags={CONSTANT}, accessor="1", conditional="defined(HAVE_TTYNAME)")
    public static boolean HAVE_TTYNAME;

    /**
     * test whether a file descriptor refers to a terminal
     * 
     * @param fd file descriptor
     * @return isatty() returns 1 if fd is an open file descriptor referring to a
     * terminal; otherwise 0 is returned, and errno is set to indicate the
     * error
     * @see <a href="http://man7.org/linux/man-pages/man3/isatty.3.html">ISATTY(3) man-page</a>
     * @see <a href="http://man7.org/linux/man-pages/man3/isatty.3p.html">ISATTY(3P) man-page</a>
     */
    @JniMethod(conditional="FALSE")
    public static native int isatty(
            @JniArg int fd);

    @JniMethod(conditional="FALSE")
    public static native String ttyname(
            @JniArg int filedes);

    /**
     * The openpty() function finds an available pseudoterminal and returns
     * file descriptors for the master and slave in amaster and aslave.
     * @param amaster master return value
     * @param aslave slave return value
     * @param name filename return value
     * @param termios
     * @param winsize
     * @return 0 on success
     * @see <a href="http://man7.org/linux/man-pages/man3/openpty.3.html">OPENPTY(3) man-page</a>
     */
    @JniMethod(conditional="defined(HAVE_OPENPTY)")
    public static native int openpty(
            @JniArg(cast="int *", flags={NO_IN}) int[] amaster,
            @JniArg(cast="int *", flags={NO_IN}) int[] aslave,
            @JniArg(cast="char *", flags={NO_IN}) byte[] name,
            @JniArg(cast="struct termios *", flags={NO_OUT}) Termios termios,
            @JniArg(cast="struct winsize *", flags={NO_OUT}) WinSize winsize);

    @JniMethod(conditional="defined(HAVE_TCGETATTR)")
    public static native int tcgetattr(
            @JniArg int filedes,
            @JniArg(cast="struct termios *", flags={NO_IN}) Termios termios);

    @JniMethod(conditional="defined(HAVE_TCSETATTR)")
    public static native int tcsetattr(
            @JniArg int filedes,
            @JniArg int optional_actions,
            @JniArg(cast="struct termios *", flags={NO_OUT}) Termios termios);

    /*
     * Commands passed to tcsetattr() for setting the termios structure.
     */
    @JniField(flags={CONSTANT}, conditional="defined(TCSANOW)")
    public static int TCSANOW;		    /* make change immediate */
    @JniField(flags={CONSTANT}, conditional="defined(TCSADRAIN)")
    public static int TCSADRAIN;		/* drain output, then change */
    @JniField(flags={CONSTANT}, conditional="defined(TCSAFLUSH)")
    public static int TCSAFLUSH;		/* drain output, flush input */

    @JniField(flags={CONSTANT}, conditional="defined(TIOCGETA)")
    public static long TIOCGETA;
    @JniField(flags={CONSTANT}, conditional="defined(TIOCSETA)")
    public static long TIOCSETA;
    @JniField(flags={CONSTANT}, conditional="defined(TIOCGETD)")
    public static long TIOCGETD;
    @JniField(flags={CONSTANT}, conditional="defined(TIOCSETD)")
    public static long TIOCSETD;
    /**
     * ioctl command: Get window size.
     */
    @JniField(flags={CONSTANT}, conditional="defined(TIOCGWINSZ)")
    public static long TIOCGWINSZ;
    /**
     * ioctl command: Set window size.
     */
    @JniField(flags={CONSTANT}, conditional="defined(TIOCSWINSZ)")
    public static long TIOCSWINSZ;

    /**
     * Control a STREAMS device.
     *
     * @param filedes
     * @param request
     * @param params
     * @return
     * @see <a href="http://man7.org/linux/man-pages/man3/ioctl.3p.html">IOCTL(3P) man-page</a>
     */
    @JniMethod(conditional="defined(HAVE_IOCTL)")
    public static native int ioctl(
            @JniArg int filedes,
            @JniArg long request,
            @JniArg int[] params);

    @JniMethod(conditional="defined(HAVE_IOCTL)")
    public static native int ioctl(
            @JniArg int filedes,
            @JniArg long request,
            @JniArg(flags = ArgFlag.POINTER_ARG) WinSize params);

    /**
     * Window sizes.
     * @see <a href="http://man7.org/linux/man-pages/man4/tty_ioctl.4.html">IOCTL_TTY(2) man-page</a>
     */
    @JniClass(flags={ClassFlag.STRUCT}, name="winsize", conditional="defined(HAVE_IOCTL)")
    public static class WinSize {

        static {
            LIBRARY.load();
            init();
        }

        @JniMethod(flags={CONSTANT_INITIALIZER})
        private static native void init();
        @JniField(flags={CONSTANT}, accessor="sizeof(struct winsize)")
        public static int SIZEOF;

        @JniField(accessor="ws_row")
        public short ws_row;
        @JniField(accessor="ws_col")
        public short ws_col;
        @JniField(accessor="ws_xpixel")
        public short ws_xpixel;
        @JniField(accessor="ws_ypixel")
        public short ws_ypixel;

        public WinSize() {
        }

        public WinSize(short ws_row, short ws_col) {
            this.ws_row = ws_row;
            this.ws_col = ws_col;
        }
    }

    /**
     * termios structure for termios functions, describing a general terminal interface that is
     * provided to control asynchronous communications ports
     *
     * @see <a href="http://man7.org/linux/man-pages/man3/termios.3.html">TERMIOS(3) man-page</a>
     */
    @JniClass(flags={ClassFlag.STRUCT}, name="termios", conditional = "defined(HAVE_IOCTL)")
    public static class Termios {

        static {
            LIBRARY.load();
            init();
        }

        @JniMethod(flags={CONSTANT_INITIALIZER})
        private static native void init();
        @JniField(flags={CONSTANT}, accessor="sizeof(struct termios)")
        public static int SIZEOF;

        @JniField(accessor="c_iflag")
        public long c_iflag;
        @JniField(accessor="c_oflag")
        public long c_oflag;
        @JniField(accessor="c_cflag")
        public long c_cflag;
        @JniField(accessor="c_lflag")
        public long c_lflag;
        @JniField(accessor="c_cc")
        public byte[] c_cc = new byte[32];
        @JniField(accessor="c_ispeed")
        public long c_ispeed;
        @JniField(accessor="c_ospeed")
        public long c_ospeed;
    }

}
