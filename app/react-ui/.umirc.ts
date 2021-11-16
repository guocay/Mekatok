import routes from './config/routers.config';
import { defineConfig } from 'umi';

export default defineConfig({
  base: '/',
  mfsu: {},
  // mock: false,
  title: process.env.APP_NAME,
  favicon: 'favicon.ico',
  routes: [routes],
  nodeModulesTransform: {
    type: 'none',
  },
  forkTSChecker: {},
  fastRefresh: {},
  dva: {
    hmr: true,
    immer: true
  },
  antd: {},
  request: {
    dataField: 'data'
  },
  locale:{
    default: 'zh-CN',
    antd: true
  }
});
