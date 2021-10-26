import routes from './config/routes';
import layout from './config/layouts';
import { defineConfig } from 'umi';

export default defineConfig({
  base: '/',
  mfsu: {},
  title: process.env.APP_NAME,
  favicon: 'favicon.ico',
  routes: routes,
  layout: layout,
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
    antd: true
  }
});
