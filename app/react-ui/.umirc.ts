import routes from './config/routes';
import { defineConfig } from 'umi';

export default defineConfig({
  base: '/',
  title: process.env.APP_NAME,
  favicon: 'favicon.ico',
  routes: routes,
  mfsu: {},
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
  layout: {
    name: process.env.APP_NAME,
    locale: true,
    layout: 'side',
  },
  locale:{
    antd: true
  }
});
