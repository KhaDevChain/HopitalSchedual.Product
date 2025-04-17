import { NextSSRPlugin } from '@uploadthing/react/next-ssr-plugin'
import type { Metadata } from 'next'
import { extractRouterConfig } from 'uploadthing/server'

import { ourFileRouter } from '@/app/api/uploadthing/core'

import '@/styles/globals.css'

export const metadata: Metadata = {
  title: 'Hopital - Your Health Matters',
  description: 'Hopital - Your Health Matters',
  category: 'hopital',
  keywords: [
    'Hopital',
    'doctor',
    'patient',
    'bệnh viện',
    'khám chữa bệnh',
    'đặt lịch khám bệnh',
    'tư vấn khám bệnh',
  ],
  openGraph: {
    title: 'Hopital - Your Health Matters',
    description: 'Hopital - Your Health Matters',
    siteName: 'heathcare',
    type: 'website',
  },
  twitter: {
    card: 'summary_large_image',
    title: 'Hopital - Your Health Matters',
    description: 'Hopital - Your Health Matters',
  },
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang='en'>
      <link rel="shortcut icon" href="/images/logo/logo-min.png" type="image/x-icon" />
      <body>
        <NextSSRPlugin
          /**
           * The `extractRouterConfig` will extract **only** the route configs
           * from the router to prevent additional information from being
           * leaked to the client. The data passed to the client is the same
           * as if you were to fetch `/api/uploadthing` directly.
           */
          routerConfig={extractRouterConfig(ourFileRouter)}
        />
        {children}
      </body>
    </html>
  )
}
