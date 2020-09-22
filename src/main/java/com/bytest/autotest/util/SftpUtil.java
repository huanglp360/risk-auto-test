//package com.bytest.autotest.util;
//
//import com.jcraft.jsch.*;
//import com.smy.framework.core.exception.CommonErrorCode;
//import com.smy.framework.core.exception.ServiceException;
//import com.smy.framework.core.util.FtpUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//
//import java.io.*;
//import java.util.*;
//
///**
// * <h3>risk-auto-test</h3>
// * <p>上传文件到sftp</p>
// *
// * @author : hh
// * @date : 2020-09-15 14:14
// **/
//@Slf4j
//public class SftpUtil {
//    private static int timeout = 20000;
//    private String host;
//    private String username;
//    private String password;
//    private String keyfilepath;
//    private int port;
//    private ChannelSftp sftp = null;
//    private Session sshSession = null;
//
//    public SftpUtil() {}
//
//    public SftpUtil(String host, int port, String username, String password)
//    {
//        this.host = host;
//        this.username = username;
//        this.password = password;
//        this.port = port;
//    }
//
//    public SftpUtil(String username, String keyFilePath, String host, int port)
//    {
//        this.host = host;
//        this.username = username;
//        this.keyfilepath = keyFilePath;
//        this.port = port;
//    }
//
//    public void connect()
//    {
//        try
//        {
//            JSch jsch = new JSch();
//            this.sshSession = jsch.getSession(this.username, this.host, this.port);
//            if (StringUtils.isNotBlank(this.keyfilepath)) {
//                jsch.addIdentity(this.keyfilepath);
//            }
//            if (StringUtils.isNotBlank(this.password)) {
//                this.sshSession.setPassword(this.password);
//            }
//            Properties sshConfig = new Properties();
//            sshConfig.put("StrictHostKeyChecking", "no");
//            this.sshSession.setConfig(sshConfig);
//            this.sshSession.setTimeout(timeout);
//            this.sshSession.connect();
//            Channel channel = this.sshSession.openChannel("sftp");
//            channel.connect();
//            this.sftp = ((ChannelSftp)channel);
//            if (log.isInfoEnabled()) {
//                log.info("Connected to " + this.host + ".");
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            log.error("sftp连接失败" + e);
//        }
//    }
//
//    public void disconnect()
//    {
//        if ((this.sftp != null) &&
//                (this.sftp.isConnected())) {
//            this.sftp.disconnect();
//        }
//        if ((this.sshSession != null) &&
//                (this.sshSession.isConnected())) {
//            this.sshSession.disconnect();
//        }
//    }
//
//    public List<String> batchDownLoadFile(String remotePath, String localPath, String fileFormat, String fileEndFormat, boolean del)
//    {
//        List<String> filenames = new ArrayList();
//        try
//        {
//            Vector<ChannelSftp.LsEntry> v = listFiles(remotePath);
//            if (v.size() > 0)
//            {
//                log.info("本次处理文件个数不为零,开始下载...fileSize=" + v.size());
//                Iterator it = v.iterator();
//                while (it.hasNext())
//                {
//                    ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry)it.next();
//                    String filename = entry.getFilename();
//                    SftpATTRS attrs = entry.getAttrs();
//                    if (!attrs.isDir())
//                    {
//                        boolean flag = false;
//                        String localFileName = localPath + filename;
//                        fileFormat = fileFormat == null ? "" : fileFormat.trim();
//                        fileEndFormat = fileEndFormat == null ? "" : fileEndFormat.trim();
//                        if ((fileFormat.length() > 0) && (fileEndFormat.length() > 0))
//                        {
//                            if ((filename.startsWith(fileFormat)) && (filename.endsWith(fileEndFormat)))
//                            {
//                                flag = downloadFile(remotePath, filename, localPath, filename);
//                                if (flag)
//                                {
//                                    filenames.add(localFileName);
//                                    if ((!flag) || (!del)) {}
//                                }
//                            }
//                        }
//                        else if ((fileFormat.length() > 0) && ("".equals(fileEndFormat)))
//                        {
//                            if (filename.startsWith(fileFormat))
//                            {
//                                flag = downloadFile(remotePath, filename, localPath, filename);
//                                if (flag)
//                                {
//                                    filenames.add(localFileName);
//                                    if ((!flag) || (!del)) {}
//                                }
//                            }
//                        }
//                        else if ((fileEndFormat.length() > 0) && ("".equals(fileFormat)))
//                        {
//                            if (filename.endsWith(fileEndFormat))
//                            {
//                                flag = downloadFile(remotePath, filename, localPath, filename);
//                                if (flag)
//                                {
//                                    filenames.add(localFileName);
//                                    if ((!flag) || (!del)) {}
//                                }
//                            }
//                        }
//                        else
//                        {
//                            flag = downloadFile(remotePath, filename, localPath, filename);
//                            if (flag)
//                            {
//                                filenames.add(localFileName);
//                                if ((!flag) || (!del)) {}
//                            }
//                        }
//                    }
//                }
//            }
//            if (log.isInfoEnabled()) {
//                log.info("下载成功:对方sftp目录为：" + remotePath + "，本地目录为：" + localPath);
//            }
//        }
//        catch (SftpException e)
//        {
//            e =
//
//
//                    e;log.error("批量下载文件异常", e);
//        }
//        finally {}
//        return filenames;
//    }
//
//    public boolean downloadFile(String remotePath, String remoteFileName, String localPath, String localFileName)
//    {
//        FileOutputStream fieloutput = null;
//        try{
//            log.info(localPath);
//            File dir = new File(localPath);
//            if (!dir.exists()){
//                log.info("创建目录" + localPath);
//
//                dir.mkdirs();
//            }
//            File file = new File(localPath + localFileName);
//            fieloutput = new FileOutputStream(file);
//            log.info(remotePath);
//            this.sftp.get(remotePath, fieloutput);
//            if (log.isInfoEnabled()) {
//                log.info("===DownloadFile:" + remoteFileName + " success from sftp.");
//            }
//            return true;
//        }
//        catch (FileNotFoundException e)
//        {
//            log.error("下载文件异常-未找到文件", e);
//            //throw new ServiceException(new String[] { "SFTP下载时文件不存在" });
//        }
//        catch (SftpException e)
//        {
//            log.error("下载文件异常-sftp异常", e);
//            //throw new ServiceException(new String[] { "SFTP下载时sftp异常" });
//        } finally
//        {
//            if (null != fieloutput) {
//                try{
//                    fieloutput.close();
//
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//            return true;
//        }
//    }
//
//    public Vector<ChannelSftp.LsEntry> listFiles(String directory)
//            throws SftpException
//    {
//        return this.sftp.ls(directory);
//    }
//
//    private static ChannelItem getChannel(FtpUtil.FtpDto ftpDto)
//            throws Exception
//    {
//        JSch jsch = new JSch();
//        Session session = jsch.getSession(ftpDto.getUser(), ftpDto.getIp(), ftpDto.getPort());
//        session.setPassword(ftpDto.getPassword());
//
//        Properties config = new Properties();
//        config.put("StrictHostKeyChecking", "no");
//        session.setConfig(config);
//        session.setTimeout(timeout);
//
//
//        session.connect();
//        Channel channel = session.openChannel("sftp");
//        channel.connect();
//
//        ChannelItem channelItem = new ChannelItem();
//        channelItem.setChannel((ChannelSftp)channel);
//        channelItem.setSession(session);
//        return channelItem;
//    }
//
//    private static void closeChannel(ChannelItem channelItem)
//    {
//        try
//        {
//            if (channelItem.getSession() != null) {
//                channelItem.getSession().disconnect();
//            }
//        }
//        catch (Exception e1)
//        {
//            log.warn("退出SFTP管道异常");
//        }
//        try
//        {
//            if (channelItem.getChannel() != null) {
//                channelItem.getChannel().disconnect();
//            }
//        }
//        catch (Exception e1)
//        {
//            log.warn("退出SFTP管道异常");
//        }
//    }
//
//    public static void upload(FtpUtil.FtpDto ftpDto)
//    {
//        log.info("开始SFTP文件上传:{}", ftpDto.getLocalFilePathName());
//        ChannelSftp chSftp = null;
//        ChannelItem channelItem = null;
//        try
//        {
//            channelItem = getChannel(ftpDto);
//            chSftp = (ChannelSftp)channelItem.getChannel();
//            OutputStream out = chSftp.put(ftpDto.getRemoteDir().concat(ftpDto.getRemoteFileName()), 0);
//            byte[] buff = new byte[262144];
//            if (out != null)
//            {
//                InputStream is = new FileInputStream(ftpDto.getLocalFilePathName());
//                int read;
//                do
//                {
//                    read = is.read(buff, 0, buff.length);
//                    if (read > 0) {
//                        out.write(buff, 0, read);
//                    }
//                    out.flush();
//                } while (read >= 0);
//            }
//        }
//        catch (Exception e)
//        {
//            log.error("SFTP文件上传失败", e);
//
//            throw new ServiceException(CommonErrorCode.ERROR_FILE_UPLOAD, new String[] { "文件上传失败" }, new String[] {ftpDto.getRemoteFileName() });
//        }
//        finally
//        {
//            if (chSftp != null) {
//                try
//                {
//                    chSftp.quit();
//                }
//                catch (Exception e)
//                {
//                    log.warn("退出SFTP管道异常");
//                }
//            }
//            closeChannel(channelItem);
//        }
//        log.info("成功SFTP文件上传:{}", ftpDto.getLocalFilePathName());
//    }
//
//    public static void download(FtpUtil.FtpDto ftpDto)
//    {
//        log.info("开始SFTP文件下载:{},远程地址：{}{}", new Object[] {ftpDto
//                .getLocalFilePathName(), ftpDto
//                .getRemoteDir(), ftpDto
//                .getRemoteFileName() });
//        ChannelSftp chSftp = null;
//        ChannelItem channelItem = null;
//        try
//        {
//            channelItem = getChannel(ftpDto);
//            chSftp = (ChannelSftp)channelItem.getChannel();
//            InputStream is = chSftp.get(ftpDto.getRemoteDir().concat(ftpDto.getRemoteFileName()));
//            OutputStream out = new FileOutputStream(ftpDto.getLocalFilePathName());
//            byte[] buff = new byte[2048];
//            if (is != null)
//            {
//                int read;
//                do
//                {
//                    read = is.read(buff, 0, buff.length);
//                    if (read > 0) {
//                        out.write(buff, 0, read);
//                    }
//                    out.flush();
//                } while (read >= 0);
//            }
//        }
//        catch (SftpException se)
//        {
//            log.error("SFTP文件下载失败", se);
//            throw new ServiceException(CommonErrorCode.ERROR_FILE_DOWNLOAD, new String[] { "文件下载失败" }, new String[] { ftpDto.getRemoteFileName() });
//        }
//        catch (Exception e)
//        {
//            log.error("SFTP文件下载失败", e);
//            throw new ServiceException(CommonErrorCode.ERROR_FILE_UPLOAD, new String[] { "文件下载失败" }, new String[] { ftpDto.getRemoteFileName() });
//        }
//        finally
//        {
//            if (chSftp != null) {
//                try
//                {
//                    chSftp.quit();
//                }
//                catch (Exception e)
//                {
//                    log.warn("退出SFTP管道异常");
//                }
//            }
//            closeChannel(channelItem);
//        }
//        log.info("成功SFTP文件下载:{}", ftpDto.getLocalFilePathName());
//    }
//
//    static class ChannelItem
//    {
//        Session session;
//        Channel channel;
//
//        public Session getSession()
//        {
//            return this.session;
//        }
//
//        public void setSession(Session session)
//        {
//            this.session = session;
//        }
//
//        public Channel getChannel()
//        {
//            return this.channel;
//        }
//
//        public void setChannel(Channel channel)
//        {
//            this.channel = channel;
//        }
//    }
//
//    public static class MyProgressMonitor
//            implements SftpProgressMonitor
//    {
//        private long transfered;
//
//        public MyProgressMonitor(long transfered)
//        {
//            this.transfered = transfered;
//        }
//        @Override
//        public boolean count(long count)
//        {
//            this.transfered += count;
//            return true;
//        }
//        @Override
//        public void end() {}
//        @Override
//        public void init(int op, String src, String dest, long max) {}
//    }
//
//    public static void main(String[] args)
//            throws Exception
//    {
//        FtpUtil.FtpDto dto = new FtpUtil.FtpDto();
//        dto.setIp("124.251.54.6");
//        dto.setPort(7722);
//        dto.setUser("smyf");
//        dto.setPassword("smyf12#");
//
//
//        dto.setRemoteDir("/home/sunfcbp/file/smyf/chck/");
//        dto.setProxyType(FtpUtil.ProxyType.HTTP);
//        dto.setProxyHost("192.168.2.220");
//        dto.setProxyPort(3128);
//        dto.setRemoteFileName("CORE_ZHDC_BZ_20160610.txt");
//        dto.setLocalFilePathName("C:/Temp/CORE_LOAN_TRANS_20160318.txt");
//
//        download(dto);
//    }
//
//    public void testFtp()
//    {
//        FtpUtil.FtpDto dto = new FtpUtil.FtpDto();
//        dto.setIp("124.251.54.6");
//        dto.setPort(7922);
//        dto.setUser("sunfcbp");
//        dto.setPassword("sunfcbp");
//
//
//        dto.setRemoteDir("/home/sunfcbp/file/smyf/img/");
//        dto.setProxyType(FtpUtil.ProxyType.HTTP);
//        dto.setProxyHost("192.168.2.220");
//        dto.setProxyPort(3128);
//        dto.setRemoteFileName("a.rar");
//        dto.setLocalFilePathName("C:/Temp/LibAntiPrtSc_ERROR.rar");
//
//        FtpUtil.upload(dto);
//    }
//
//    public void createTxtFile(String filePath, String fileContent)
//    {
//        try
//        {
//            FileWriter fw = new FileWriter(filePath, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write(fileContent);
//            bw.close();
//            fw.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//}
