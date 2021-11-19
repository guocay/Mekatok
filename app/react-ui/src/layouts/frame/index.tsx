import ProLayout, { DefaultFooter, PageContainer } from '@ant-design/pro-layout';
import { Link } from 'umi';

export default (props: any) => {
    const { route } = props
    return (
        <ProLayout title='Mekatok React App' siderWidth={270} location={{pathname:'/'}} route={route} collapsedButtonRender={false}
            footerRender={() => (<DefaultFooter links={[]} copyright="Guo Kai" />)}
            menuItemRender={(item, dom) => (
               <Link to={item.path ?? '/'}>{dom}</Link>
            )}
        >
            <PageContainer fixedHeader>
                { props.children }
            </PageContainer>
        </ProLayout>
    )
}
