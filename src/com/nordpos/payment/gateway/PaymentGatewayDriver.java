/**
 *
 * NORD POS is a fork of Openbravo POS.
 *
 * Copyright (C) 2009-2014 Nord Trading Ltd. <http://www.nordpos.com>
 *
 * This file is part of NORD POS.
 *
 * NORD POS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * NORD POS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * NORD POS. If not, see <http://www.gnu.org/licenses/>.
 */
package com.nordpos.payment.gateway;

import com.nordpos.device.util.StringParser;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 * @version NORD POS 3
 */
public class PaymentGatewayDriver implements PaymentGatewayInterface {

    @Override
    public PaymentGateway getPaymentGateway(String sProperty) {
        StringParser displayProperty = new StringParser(sProperty);
        String sDisplayType = displayProperty.nextToken(':');
        switch (sDisplayType) {
            case "AuthorizeNet":
                return new PaymentGatewayExt();
            default:
                return null;
        }
    }

    @Override
    public PaymentGatewayConfiguration getPaymentGatewayConfiguration(String sProperty) {
        StringParser displayProperty = new StringParser(sProperty);
        String sDisplayType = displayProperty.nextToken(':');
        switch (sDisplayType) {
            case "AuthorizeNet":
                return new ConfigPaymentPanelGeneric();
            default:
                return null;
        }
    }
}
