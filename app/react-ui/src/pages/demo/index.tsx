import styles from './index.less';
import { Button } from "antd";
import { SmileOutlined, CrownOutlined, TabletOutlined, AntDesignOutlined } from '@ant-design/icons';
import Footer from '@/components/footer';

export default () => {
  return (
    <div>
        <SmileOutlined />
        <CrownOutlined />
        <TabletOutlined />
        <AntDesignOutlined />
        <br />
        <Button type="primary">Primary Button</Button>
        <Footer />
    </div>
  );
}
