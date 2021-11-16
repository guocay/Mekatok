import { IBestAFSRoute } from '@umijs/plugin-layout'

const routes: IBestAFSRoute = {
        path: '/',
        component: '@/layouts/frame/index',
        routes: [
            {
                path: '/test',
                name: 'TestPage',
                component: '@/pages/demo/index'
            },
            {
                path: '/test1',
                name: '测试页面',
                component: '@/pages/demo/index'
            }
        ]
}

export default routes
